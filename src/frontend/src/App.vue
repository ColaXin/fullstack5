<script setup>
import {RouterLink, RouterView} from "vue-router"

</script>

<template>
  <div class="template">
    <nav class="links">
      <RouterLink to="/">Calculator</RouterLink>
      <RouterLink to="/contact"> Contact Us</RouterLink>
    </nav>
    <RouterView></RouterView>
  </div>
</template>

<style scoped>
.links {
  display: flex;
  justify-content: space-evenly;
  max-width: 150px;
  background: transparent;
  border-radius: 3px;
  font-family: "Agency FB";
}
</style>
