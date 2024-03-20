<script setup>
const props = defineProps({
expressions: Array,
results: Array
});
</script>

<template>
  <div id="logContainer">
    <div v-for="(expression, index) in [...expressions].reverse()" :key="index">
      <div class="small-text">{{ expression }}</div>
      <div class="large-text">{{ [...results].reverse()[index] }}</div>
    </div>
  </div>
</template>

<style scoped>
#logContainer {
  height: 300px;
  overflow-y: auto;
  background-color: black;
  border: green;
  padding: 10px;
  display: flex;
  flex-grow: 1;
  flex-direction: column;
  border-radius: 4px;

  margin: 5px;
}

.small-text {
  font-size: 12px;
  font-family: "Lucida Console";
  color: green;
  margin-bottom: 0;
}

.large-text {
  font-size: 24px;
  font-family: "Lucida Console";
  color: lightgreen;
  margin-top: 2px;
  margin-bottom: 5px;
}
</style>
