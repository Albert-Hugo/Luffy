package com.ido.luffy;

public interface Authentication {

    /**
     * the login user id
     *
     * @return
     */
    String getUserId();

    /**
     * get the login user role
     *
     * @return
     */
    String getRole();

    /**
     * the user name
     *
     * @return
     */
    String getUserName();


}
