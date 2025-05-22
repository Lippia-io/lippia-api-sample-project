package api.config;

import services.*;

public enum EntityConfiguration {

    USER {
        @Override
        public Class<?> getEntityService() {
            return UserService.class;
        }
    },
    WORKSPACE {
        @Override
        public Class<?> getEntityService() {
            return WorkspaceService.class;
        }
    },

    ADDWORKSPACE {
        @Override
        public Class<?> getEntityService() {
            return AddWorkspaceService.class;
        }

    },
    PROJECTS {
        @Override
        public Class<?> getEntityService() {
            return ProjectsService.class;
        }

    },
    CLIENTS {
        @Override
        public Class<?> getEntityService() {
            return ClientsService.class;
        }

    };


    public abstract Class<?> getEntityService();
}



