package com.am.telegram.groupstat.user.report.group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupRepository {

    public List<GroupDTO> findAllGroups(Connection connection) throws SQLException {
        String query = "SELECT GROUP_ID, GROUP_INTERNAL_NAME, GROUP_CITY, GROUP_CATEGORY, GROUP_ADDED_AT, GROUP_ADDED_BY FROM groups";
        List<GroupDTO> groupDTOs = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                GroupDTO groupDTO = new GroupDTO();
                groupDTO.setId(rs.getInt("GROUP_ID"));
                groupDTO.setInternalName(rs.getString("GROUP_INTERNAL_NAME"));
                groupDTO.setCity(rs.getString("GROUP_CITY"));
                groupDTO.setCategory(rs.getString("GROUP_CATEGORY"));
                groupDTO.setAddedAt(rs.getDate("GROUP_ADDED_AT").toLocalDate());
                groupDTO.setAddedBy(rs.getString("GROUP_ADDED_BY"));
                groupDTOs.add(groupDTO);
            }
        }

        return groupDTOs;
    }
}
