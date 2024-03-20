<script>
export default {
  props:  {
    label: {
      type: String,
      default: ''
    },
    modelValue: {
      type: [String, Number],
      default: ''
    }
  }
}
</script>

<template>

  <div class="container">
    <label class="label">{{label}}</label>
    <input
        v-bind="$attrs"
        :placeholder="label"
        :value="modelValue"
        class="field"
        @input="$emit('update:modelValue', $event.target.value)"
    >
  </div>

</template>

<style scoped>
.container {
  overflow-y: auto;
  padding: 10px;
  display: flex;
  flex-grow: 1;
  flex-direction: column;
  margin: 5px;
}

.label {
  font-size: 16px;
  font-family: "Arial";
  margin-bottom: 0;
}

.field {
  font-size: 20px;
  font-family: "Arial";
  color: black;
  width: 200px;
  margin-top: 2px;
  margin-bottom: 5px;
}



</style>