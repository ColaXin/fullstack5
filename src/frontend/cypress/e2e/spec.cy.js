describe('Load Main', () => {
  it('Loading calculator', () => {
    cy.visit('http://localhost:5173')
  })
})

describe('Load Form', () => {
  it('loading form', () => {
    cy.visit('http://localhost:5173/contact')
  })
})

describe('Form', () => {
  it('Fill and validate form', () => {
    cy.visit('http://localhost:5173/contact')
    cy.get('#name-input').find("input").type('John Doe')
    cy.get('#email-input').find("input").type('john@doe.com')
    cy.get('#message-input').find("input").type('Hello, this is a test message')

    cy.get('button').click()

    cy.on('window:alert', (str) => {
      expect(str).to.equal("Form submitted successfully!");
    });
  });
})

describe('Test checks', () => {
  it('Check if the form is not submitted with empty fields', () => {
    cy.visit('http://localhost:5173/contact')
    cy.get('button').should('be.disabled')
    cy.get('#name-input').find("input").type('John Doe')
    cy.get('button').should('be.disabled')
    cy.get('#email-input').find("input").type('john@doe.com')
    cy.get('button').should('be.disabled')
    cy.get('#message-input').find("input").type('Hello, this is a test message')
    cy.get('button').should('not.be.disabled')
    cy.get('button').click()
    cy.on('window:alert', (str) => {
      expect(str).to.equal("Form submitted successfully!");
    });
  });
})
