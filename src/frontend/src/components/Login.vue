<template>
  <div>
    <input v-model="credentials.username" type="text" placeholder="Username" />
    <input v-model="credentials.password" type="password" placeholder="Password" />
    <button @click="submitCredentials">Submit</button>

    <!-- Display calculations -->
    <div v-if="calculations.length > 0">
      <h3>Calculations:</h3>
      <ul>
        <li v-for="(calc, index) in calculations" :key="index">
          {{ calc.expression }} = {{ calc.result }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Login',
  data() {
    return {
      credentials: {
        username: '',
        password: '',
      },
      calculations: [] // Stores calculations
    };
  },
  methods: {
    async submitCredentials() {
      try {
        // Replace the URL with the correct endpoint
        const response = await axios.post('http://localhost:8080/calculations/login', this.credentials);
        // Assuming the response contains the list of calculations
        this.calculations = response.data;

        let cleanData = JSON.parse(JSON.stringify(response.data, (key, value) => {
          if (key === 'user') return undefined; // Removes the user property
          return value;
        }));
        console.log(cleanData);
      } catch (error) {
        console.error("There was an error submitting the credentials:", error);
        // Optionally, handle the error (e.g., show an error message)
      }
      // Login component
      this.$emit('credentialsSubmitted', { username: this.credentials.username, password: this.credentials.password });

    },
  },
};
</script>

<style>
/* Add any styles for your component here */
</style>
