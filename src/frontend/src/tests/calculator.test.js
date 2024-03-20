import { describe, it, expect } from 'vitest';
import { mount } from '@vue/test-utils';
import Calculator from '@/components/Calculator.vue';

describe('Calculator', () => {
    // Test input method
    it('appends a character to the calculation string', () => {
        const wrapper = mount(Calculator);
        wrapper.vm.input('5');
        expect(wrapper.vm.calculation).toBe('5');
    });

    // Test delete method
    it('deletes the last character from the calculation string', () => {
        const wrapper = mount(Calculator);
        wrapper.vm.input('5');
        wrapper.vm.delete();
        expect(wrapper.vm.calculation).toBe('');
    });

    // Test calculate method - Simple calculation
    it('calculates the expression correctly', async () => {
        const wrapper = mount(Calculator);
        wrapper.vm.input('2');
        wrapper.vm.input('+');
        wrapper.vm.input('2');
        await wrapper.vm.calculate();
        expect(wrapper.vm.resultArray[0]).toBe('4');
    });

    // Handle Error - Test calculate method with an invalid expression
    it('handles errors in calculation and sets calculation to "Error"', async () => {
        const wrapper = mount(Calculator);
        wrapper.vm.input('/');
        try {
            await wrapper.vm.calculate();
        } catch (e) {
            // Catching error thrown by `calculate` method
        }
        expect(wrapper.vm.calculation).toBe('Error');
    });

    // More tests can be added to cover other methods and edge cases
});
