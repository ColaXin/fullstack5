<script setup>
import { watch, ref } from 'vue';

const props = defineProps({
  displayedString: {
    type: String,
    default: ""
  }
});

const displayTextRef = ref(null);

watch(() => props.displayedString, (newValue) => {
  if (displayTextRef.value) {
    adjustFontSize(displayTextRef.value, newValue);
  }
});

function adjustFontSize(element, text) {
  let fontSize = parseInt(window.getComputedStyle(element).fontSize);
  const maxWidth = element.parentElement.offsetWidth - 20; // Adjust based on padding
  element.style.fontSize = fontSize + 'px'; // Reset font size

  while (element.scrollWidth > maxWidth && fontSize > 10) {
    fontSize--;
    element.style.fontSize = fontSize + 'px';
  }
}
</script>

<template>
  <div class="display">
    <div ref="displayTextRef" class="displayText">
      {{ displayedString.replaceAll('*', 'x') }}
    </div>
  </div>
</template>


<style scoped>

.display {
  display: flex;
  height:50px;
  position: relative;
  background: greenyellow;
  margin-bottom: 10px;
  border-radius: 4px;
}
.displayText {
  font-family: calculator;
  font-size: xxx-large;
}
</style>
