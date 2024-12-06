/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    '../../../templates/IndexController/index.html',
  ],
  theme: {
    container: {
      center: true,
      padding: '2rem',
    },
    extend: {},
  },
  plugins: [
    require('@tailwindcss/forms'),
    require('@tailwindcss/typography'),
  ],
}

