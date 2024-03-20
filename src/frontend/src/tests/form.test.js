// Import Vue Test Utils and the component to test
import { describe, it, expect, vi } from 'vitest';
import { mount } from '@vue/test-utils';
import Form from '@/components/Form.vue';

// Mock necessary imports
vi.mock('@/stores/FormStore.js', () => ({
    useFormStore: () => ({
        name: '',
        email: '',
        message: ''
    })
}));

// Mock global fetch
global.fetch = vi.fn(() =>
    Promise.resolve({
        ok: true,
        json: () => Promise.resolve({ success: true }),
    })
);

describe('Form', () => {
    it('disables submit button when form is invalid', async () => {
        const wrapper = mount(Form);
        // Initially, the form is invalid, so the submit button should be disabled.
        expect(wrapper.find('button[type="submit"]').attributes('disabled')).toBeDefined();
    });

    it('enables submit button when form is valid', async () => {
        const wrapper = mount(Form, {
            global: {
                mocks: {
                    useFormStore: () => ({
                        name: 'Jane Doe',
                        email: 'jane@example.com',
                        message: 'Hello'
                    })
                }
            }
        });
        await wrapper.vm.$nextTick();

        expect(wrapper.find('button[type="submit"]').attributes('disabled')).toBe('');

    });
});
