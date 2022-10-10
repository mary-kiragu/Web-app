package com.security.group9.service;

import com.security.group9.domain.*;
import com.security.group9.repos.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import java.awt.print.*;
import java.util.*;

@Service
@Slf4j
public class GroupMemberService {
    private final GroupMembersRepo groupMembersRepo;

    public GroupMemberService(GroupMembersRepo groupMembersRepo) {
        this.groupMembersRepo = groupMembersRepo;
    }

    public GroupMembers create(GroupMembers groupMember){
        log.info("about to create group member: {}",groupMember);
        groupMember=groupMembersRepo.save(groupMember);
        log.info("created group member: {}",groupMember);


        return groupMember;
    }

    public List<GroupMembers> getAll() {
        List<GroupMembers> members=groupMembersRepo.findAll();
        log.info(" Found all Group members :{}",members);
        return  members;

    }



    public Optional<GroupMembers> findById(Long id) {
        log.info("About to find  group member with id : {}",id);

        Optional<GroupMembers> groupMember = groupMembersRepo.findById(id);
        log.info("found geoup member: {}",groupMember);

                return groupMember;
    }

    public Optional<GroupMembers> update(Long id, String name, String phoneNumber) {
        Optional<GroupMembers> groupMembersOptional=groupMembersRepo.findById(id);
        log.info("Group member found with id {}", id);
        if (groupMembersOptional.isPresent()) {
            GroupMembers groupMembers = groupMembersOptional.get();
            if (id != null && id > 0 && !Objects.equals(groupMembersOptional.get(), id)) {
                groupMembers.setId(id);

            }
            if (name != null && name.length() > 0 && !Objects.equals(groupMembersOptional.get(), name)) {
                groupMembers.setName(name);

            }
            if (phoneNumber != null && phoneNumber.length() > 0 && !Objects.equals(groupMembersOptional.get(), phoneNumber)) {
                groupMembers.setPhoneNumber(phoneNumber);

            }
            groupMembers=groupMembersRepo.save(groupMembers);
            return Optional.of(groupMembers);
        }

return groupMembersOptional;
    }

    public Optional<GroupMembers> getOne(Long id) {
        Optional<GroupMembers> groupMembers=groupMembersRepo.findById(id);
        return  groupMembers;
    }

    public GroupMembers delete(Long id) {
        boolean exist = groupMembersRepo.existsById(id);
        if (!exist) {
            throw new IllegalStateException("member doesn't exist");

        }
        groupMembersRepo.deleteById(id);
        return null;
    }

    public List<GroupMembers> filterByName(String name ) {
        log.info("About to get all members with name : {}", name);
        List<GroupMembers> membersList = groupMembersRepo.findByName(name);

         log.info(" group members {}", membersList);

        return membersList;
    }


}
