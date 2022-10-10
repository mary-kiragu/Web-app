package com.security.group9.controllers;

import com.security.group9.domain.*;
import com.security.group9.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="/api/group")
public class GroupMemmbersController {
    private final GroupMemberService groupMemberService;

    public GroupMemmbersController(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }

    @PostMapping
    ResponseEntity<GroupMembers> create(@RequestBody GroupMembers groupMembers){
    GroupMembers newgroupMember=groupMemberService.create(groupMembers);
    return new ResponseEntity<>(newgroupMember, HttpStatus.OK);
    }
    @GetMapping
    ResponseEntity <List<GroupMembers>> getAll(){
        List<GroupMembers> members=groupMemberService.getAll();
        return new ResponseEntity<>(members,HttpStatus.OK);
    }

    
}
