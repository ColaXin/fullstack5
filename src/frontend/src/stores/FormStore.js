// src/stores/formStore.js
import { defineStore } from 'pinia';

export const useFormStore = defineStore('form', {
    state: () => ({
        name: '',
        email: '',
    }),
    actions: {
        setName(name) {
            this.name = name;
        },
        setEmail(email) {
            this.email = email;
        },
    },
});
