<script setup>
import Screen from "@/components/Screen.vue";
import Keypad from "@/components/Keypad.vue";
import Log from "@/components/Log.vue";
import axios from "axios";
</script>

<script>



import axios from "axios";

export default {
  name: "Calculator",
  components: {
    'Screen': Screen,
    'Keypad': Keypad,
    'Log': Log
  },
  data() {
    return {
      calculation: "",
      expressionArray: [],
      resultArray: [],
    };
  },
  methods: {
    input(char) {
      if ((this.calculation[this.calculation.length - 1] === 'r')) {
        this.delete();
      }
      const operators = ['+', '-', '*', '/'];
      const lastChar = this.calculation[this.calculation.length - 1];

      if (operators.includes(char) && (lastChar === ',' || operators.includes(lastChar))) {
        return;
      }
      if (char === '.' && lastChar === '.') {
        return;
      }
      if (char === '.') {
        const lastNumberSegment = this.calculation.split(/[\+\-\*\/]/).pop();
        if (lastNumberSegment.includes('.')) {
          return;
        }
      }
      this.append(char)
    },
    append(a) {
      if(this.calculation.length < 32 ) {this.calculation += a}
    },
    delete() {
      if ((this.calculation[this.calculation.length - 1] === 's')) {
        this.calculation = this.calculation.slice(0, -3);
      } else if ((this.calculation[this.calculation.length - 1] === 'r')) {
        this.calculation = this.calculation.slice(0, -5);
      } else {
        this.calculation = this.calculation.slice(0, -1);
      }

    },
    clear() {
      this.calculation = "";
    },
    invert() {
      if(this.calculation.length === 0 || this.calculation === "Error"){return}
      if (this.calculation.charAt(0) === "-") {
        this.calculation = this.calculation.slice(1);
      } else {
        this.calculation = "-" + this.calculation;
      }
    },
    async calculate() {
      if (this.calculation === "Error") {
        // Handle error case appropriately
        return;
      }
      try {
        let expression = this.calculation.replaceAll('Ans', this.resultArray[this.resultArray.length - 1]);


        const response = await axios.post('http://localhost:8080/calculator/evaluate', { expression });

        if (!response.data.success) {
          this.expressionArray.push("Error");
          this.resultArray.push(response.data.message);
          return
        }
        let calculated = response.data.result;

        if (calculated === "Error") {
          this.calculation = "Error";
        }


        // Update the arrays with the expression and the result
        this.expressionArray.push(expression.toString().replaceAll('*', 'x'));
        this.resultArray.push(calculated);

        // Clear the current calculation or handle as needed
        this.clear();
      } catch (e) {
        console.error(e); // Log or handle errors appropriately
        this.calculation = "Error";
      }
    }
  }
}
</script>

<template>
  <div class="container">
    <Screen   :displayedString="calculation"/>
    <div class="input-container">
      <Keypad @input="input"
              @calculate="calculate"
              @delete="this.delete"
              @clear="clear"
              @invert="invert"/>
      <Log   :results="resultArray" :expressions="expressionArray"/>
    </div>
    </div>

</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  margin: auto;
  flex-shrink: 0;
  width: 50%;
  border: 3px solid dimgray;
  background-color: darkgrey;
  border-radius: 10px;
  padding: 10px;
}
.input-container {
  display: flex;
  flex-direction: row;
}
</style>
