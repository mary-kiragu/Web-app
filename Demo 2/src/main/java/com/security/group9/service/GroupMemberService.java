package com.security.group9.service;

import com.security.group9.domain.*;
import com.security.group9.repos.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class GroupMemberService {
    private final GroupMembersRepo groupMembersRepo;

    public GroupMemberService(GroupMembersRepo groupMembersRepo) {
        this.groupMembersRepo = groupMembersRepo;
    }

    public GroupMembers create(GroupMembers groupMembers){
        groupMembersRepo.save(groupMembers);


        return groupMembers;
    }

    public List<GroupMembers> getAll() {
        List<GroupMembers> members=groupMembersRepo.findAll();
        return  members;

    }
}
