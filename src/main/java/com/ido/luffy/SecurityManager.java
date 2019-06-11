package com.ido.luffy;


import java.util.Map;
import java.util.Set;

public class SecurityManager {
    public static final String ADMIN_ROLE = RoleConstant.ADMIN;
    private static Map<String, Set<String>> rolesUrlTable;
    private static ThreadLocal<Authentication> authenticationThreadLocal = new ThreadLocal<>();
    private static RolePermissionRepo rolePermissionRepo;

    /**
     * need to set authentication after user pass jtw token verification
     *
     * @param a
     */
    public static void setUserAuthorization(Authentication a) {
        authenticationThreadLocal.set(a);


    }

    public static Authentication getUserAuthorization() {
        Authentication authentication = authenticationThreadLocal.get();
        return authentication;

    }


    public static Integer getUserId() {
        Authentication a = getUserAuthorization();
        if (a == null) {
            return null;
        }

        return Integer.valueOf(a.getUserId());


    }


    /**
     * @param table
     */
    public static void init(Map<String, Set<String>> table, RolePermissionRepo permissionRepo) {
        rolesUrlTable = table;
        rolePermissionRepo = permissionRepo;
    }


    public static Set<String> getRolePermission(String role) {
        if (rolePermissionRepo == null) {
            return rolesUrlTable.get(role);
        }

        return rolePermissionRepo.rolePermission(role);
    }


}
