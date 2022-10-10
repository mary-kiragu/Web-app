package com.security.group9.controllers;

import com.security.group9.domain.*;
import com.security.group9.service.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="/api/group")
@Slf4j
public class GroupMemmbersController {
    private final GroupMemberService groupMemberService;

    public GroupMemmbersController(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }

    @PostMapping
    ResponseEntity<GroupMembers> create(@RequestBody GroupMembers groupMembers){
        log.info("Request to create group member");
    GroupMembers newgroupMember=groupMemberService.create(groupMembers);
    return new ResponseEntity<>(newgroupMember, HttpStatus.OK);
    }
    @GetMapping
    ResponseEntity <List<GroupMembers>> getAll(){
        List<GroupMembers> members=groupMemberService.getAll();
        return new ResponseEntity<>(members,HttpStatus.OK);
    }

    @PutMapping("{id}")
    ResponseEntity update(@RequestBody GroupMembers groupMembers, @PathVariable Long id){
        log.info("Request to update  group member with id: {}",id);
        Optional<GroupMembers> updatedMember=null;
       updatedMember=groupMemberService.update(id,groupMembers.getName(),groupMembers.getPhoneNumber());
        log.info("updated group member: {}",updatedMember);
        return new ResponseEntity<>(updatedMember,HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<GroupMembers> getOne(@PathVariable("id") Long id) {
        log.info("About to get user with id {}",id);
        Optional<GroupMembers> groupMembersOptional = groupMemberService.getOne(id);
        log.info("found geoup member: {}",groupMembersOptional);
        GroupMembers groupMember = null;
        if (groupMembersOptional.isPresent()) {
            groupMember = groupMembersOptional.get();
            log.info("found group member: {}",groupMember);
        }
        return new ResponseEntity<>(groupMember, HttpStatus.OK);
    }

    @DeleteMapping(path="{id}")
        ResponseEntity delete(@PathVariable("id") Long id){
        log.info(" About to delete member with id :  {}",id);
        GroupMembers deletedMember=groupMemberService.delete(id);
        return new ResponseEntity(deletedMember,HttpStatus.OK);
    }

    @GetMapping(path="/filter/{name}")
    public List<GroupMembers> filterByName(@PathVariable String name) {
        log.info("Request to filter by name");

        List<GroupMembers> members = groupMemberService.filterByName(name);
        log.info(" filtered by name {}",members);


        return members;
    }


   
}
