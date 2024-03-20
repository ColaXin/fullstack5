import { defineConfig } from 'vitest/config';
import vue from '@vitejs/plugin-vue';
import path from 'path'; // Ensure you have this line

export default defineConfig({
    plugins: [vue()],
    resolve: {
        alias: {
            '@': path.resolve(__dirname, './src'), // Adjust this path as necessary
        },
    },
    test: {
        globals: true,
        environment: 'jsdom',
    },
});