import { defineStore } from "pinia";
import axios from "axios";

export interface CmsKey {
    key: string;
    value: string;
    ValidFrom?: Date;
    child?: CmsKey;
    children: number;
    parent?: CmsKey;
}

export interface Environment {
    name: string;
    order: number;
    keys?: Array<CmsKey>
}

export interface Project {
    id: string;
    name: string;
    environments?: Array<Environment>
}

interface ProjectStoreState {
    projects: Array<Project>

}

export const useProjectStore = defineStore("ProjectStore", {
    state: (): ProjectStoreState => {
        return {
            projects: []
        }
    },
    getters: {
        getEnvironments: (state) => {
            return (projectId: string) => state.projects
                .find((project) => project.id === projectId).environments
                .sort((o1, o2) => (o1.order < o2.order ? -1 : 1));
        },
    },
    actions: {
        async load() {
            const result = await axios.get<any, any>("http://localhost:8080/projects/");
            if (result.data) {
                console.log(result.data)
                this.projects = result.data;
            }
        },
        async save(project: Project) {
            await axios.put<any, any>("http://localhost:8080/projects/", project);
        },
        async deleteProject(project: Project) {
            await axios.delete<any, any>(`http://localhost:8080/projects/${ project.id }`);
        },
        async deleteEnvironment(environment: Environment) {
            await axios.delete<any, any>(`http://localhost:8080/environments/${ environment.name }`);
        }
    }
})