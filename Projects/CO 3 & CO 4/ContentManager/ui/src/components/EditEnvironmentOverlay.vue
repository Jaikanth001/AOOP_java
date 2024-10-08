<script lang="ts" setup>

import { Environment } from "../stores/ProjectStore";

interface DialogProps {
  environment: Environment;
}


const props = defineProps<DialogProps>()

function save() {
  
}

</script>

<template>
  <v-overlay activator="parent"
             location-strategy="connected"
             scroll-strategy="block">
    <v-card class="dialog">
      <h3>Edit Project</h3>
      <v-text-field v-model="environment.name" label="Label"
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