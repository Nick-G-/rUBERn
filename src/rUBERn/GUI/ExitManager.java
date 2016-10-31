package rUBERn.GUI;

import java.security.Permission;

/**
 * Created by facundo on 10/31/16.
 */

    public class ExitManager extends SecurityManager {

        SecurityManager original;

        ExitManager(SecurityManager original) {
            this.original = original;
        }

        public void checkExit(int status) {
            throw( new SecurityException() );
        }

        public void checkPermission(Permission perm) {

        }

        public SecurityManager getOriginalSecurityManager() {
            return original;
        }
    }

