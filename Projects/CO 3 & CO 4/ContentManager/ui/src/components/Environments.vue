<script lang="ts" setup>

import { Environment, useProjectStore } from "../stores/ProjectStore";
import CmsKeysTable from "./CmsKeysTable.vue";
import { ref, watch } from "vue";
import EditEnvironmentOverlay from "./EditEnvironmentOverlay.vue";

interface Props {
  projectId: string;
}

const props = defineProps<Props>();

let cmsitems = ref([]);
const show = ref(false);
let overlay = ref(false);

let items = ref([]);
watch(() => props.projectId, () => {
  items.value = useProjectStore().getEnvironments(props.projectId)
})


function open(environmentName: string) {
  const environment = useProjectStore().getEnvironments(props.projectId).find(e => e.name == environmentName)
  cmsitems.value = environment.keys;
  show.value = true
}

function remove(environment: Environment) {
  useProjectStore().deleteEnvironment(environment);
}
</script>

<template>
  <p>ENVS</p>
  <v-list :lines="'one'">
    <v-list-item
        v-for="environment in items"
        :key="environment.name"
        :title="`${environment.name}`"
        @click="open(environment.name)"
    >
      <div style="display: flex; margin-left: auto; gap: 0.5rem">
        <v-list-item-action>
          <v-btn
              color="error"
              @click="overlay = !overlay"
          >EDIT
          </v-btn>
          <EditEnvironmentOverlay v-if="overlay" :environment="environment"/>
        </v-list-item-action>
        <v-list-item-action>
          <v-btn
              color="error"
              @click="remove(environment)"
          >DELETE
          </v-btn>
        </v-list-item-action>
      </div>
    </v-list-item>
  </v-list>
  <CmsKeysTable v-if="show" :items="cmsitems"/>
</template>

<style scoped>

</style>