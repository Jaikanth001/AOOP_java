<script lang="ts" setup>

import { Project, useProjectStore } from "../stores/ProjectStore";

interface DialogProps {
  project: Project;
}


const props = defineProps<DialogProps>()

function save() {
  useProjectStore().save(props.project)
}

</script>

<template>
  <v-overlay activator="parent"
             location-strategy="connected"
             scroll-strategy="block">
    <v-card class="dialog">
      <h3>Edit Project</h3>
      <v-text-field v-model="project.name" label="Label"
                    variant="solo-filled"/>
      <div>
        <v-btn
            color="error"
            @click="save"
        >SAVE
        </v-btn>
      </div>
    </v-card>
  </v-overlay>
</template>

<style scoped>
.dialog {
  padding: 1rem;
}
</style>