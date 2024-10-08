<script lang="ts" setup>

import { Project, useProjectStore } from "../stores/ProjectStore";
import { ref } from "vue";
import EditProjectOverlay from "./EditProjectOverlay.vue";
import Environments from "./Environments.vue";


let projectId = ref("");
let show = ref(false);
let overlay = ref(false);

function open(projId: string) {
  projectId.value = projId;
  show.value = true
}

function remove(project: Project) {
  useProjectStore().deleteProject(project);
}
</script>

<template>
  <p>PROJECTS</p>
  <button @click="useProjectStore().load()">LOAD</button>
  <EditProjectOverlay v-if="add" :project="{}"/>
  <v-list :lines="'one'">
    <v-list-item
        v-for="project in useProjectStore().projects"
        :key="project.id"
        @click="open(project.id)"
    >
      <v-list-item-title>{{ project.name }}</v-list-item-title>
      <div style="display: flex; justify-items: flex-end">
        <v-list-subheader class="ellipsize">
          {{ project.environments.length > 0 ? project.environments.map(e => e.name).join(", ") : "No Environments" }}
        </v-list-subheader>
        <div style="display: flex; margin-left: auto; gap: 0.5rem">
          <v-list-item-action>
            <v-btn
                color="blue"
                @click="overlay = !overlay"
            >EDIT
            </v-btn>
            <EditProjectOverlay v-if="overlay" :project="project"/>
          </v-list-item-action>
          <v-list-item-action>
            <v-btn
                color="error"
                @click="remove(project)"
            >DELETE
            </v-btn>
          </v-list-item-action>
        </div>
      </div>
    </v-list-item>
  </v-list>
  {{ show }}
  <Environments v-if="show" :project-id="projectId"/>
</template>

<style scoped>
.ellipsize {
  text-overflow-ellipsis: true;
}
</style>