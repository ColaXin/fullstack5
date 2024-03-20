<script>
import { defineComponent } from 'vue'

export default defineComponent({
  name: "Keypad"
})
</script>

<template>
  <div class =keypad-wrapper>
    <div class="function-buttons">
      <button class="key func" @click="$emit('invert')">+/-</button>
      <button class="key func" @click="$emit('input', 'Ans')">Ans</button>
      <button class="key func" @click="$emit('delete')">C</button>
      <button class="key func" @click="$emit('clear')">AC</button>
    </div>
    <div class="buttons-wrapper">
      <div class="numpad-container">
        <button class="key number" @click="$emit('input', 1)">1</button>
        <button class="key number" @click="$emit('input', 2)">2</button>
        <button class="key number" @click="$emit('input', 3)">3</button>
        <button class="key number" @click="$emit('input', 4)">4</button>
        <button class="key number" @click="$emit('input', 5)">5</button>
        <button class="key number" @click="$emit('input', 6)">6</button>
        <button class="key number" @click="$emit('input', 7)">7</button>
        <button class="key number" @click="$emit('input', 8)">8</button>
        <button class="key number" @click="$emit('input', 9)">9</button>
        <button class="key number" @click="$emit('input',  0)">0</button>
        <button class="key number" @click="$emit('input', '.')">.</button>

        <button class="key operator" @click="$emit('calculate')">=</button>

      </div>
      <div class="operators">
        <button class="key operator" @click="$emit('input', '+')">+</button>
        <button class="key operator" @click="$emit('input', '-')">-</button>
        <button class="key operator" @click="$emit('input', '/')">/</button>
        <button class="key operator" @click="$emit('input', '*')">x</button>
      </div>
    </div>
  </div>




</template>

<style scoped>
.key {
  font-size: large;
  text-align: center;
  padding-top: 8px;
  padding-left: 10px;
  padding-right: 10px;
  width: 60px;
  height: 60px;
  font-size: xx-large;
  font-family: "Lucida Console";
  border-radius: 4px;
}

.number {
  background: lightslategray;
}

.operator {
  background: orange;
}

.func {
  background: coral;
  font-size: x-large;
}

.buttons-wrapper {
  display: flex;
  flex-direction: row;
}

.numpad-container {
  width: 200px;
  height: 250px;
  display: flex;
  justify-content: space-evenly;
  align-content: space-evenly;
  flex-wrap: wrap;
}

.function-buttons {
  display: flex;
  width: 265px  ;
  justify-content: space-evenly;
  align-content: space-evenly;
  flex-wrap: wrap;
}

.operators {
  display: flex;
  flex-direction: column;
  height: 250px;
  align-content: space-evenly;
  justify-content: space-evenly;
}

.keypad-wrapper {
  display: flex;
  flex-direction: column;
  border-radius: 10px;
  background-color: darkgrey;
  width: 265px;
  padding-top: 5px;
  padding-bottom: 5px;

}

</style>