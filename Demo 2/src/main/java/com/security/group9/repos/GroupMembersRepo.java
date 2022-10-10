package com.security.group9.repos;

import com.security.group9.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface GroupMembersRepo extends JpaRepository<GroupMembers,Long> {
    List<GroupMembers> findByName(String name);
}
