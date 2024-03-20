import {createRouter, createWebHistory} from "vue-router";
import Calculator from "../components/Calculator.vue";
import Form from "../components/Form.vue";

export default createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'calculator',
            component: Calculator,
        },
        {
            path: '/contact',
            name: 'contact',
            component: Form,
        }
    ]

});