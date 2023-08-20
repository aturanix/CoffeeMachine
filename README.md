CoffeeMachine
===
This is a project I did during one of my interview processes.

### Steps
1. The user looks at coffee prices
2. The user chooses a coffee
3. The user sees a message indicating the coffee is being prepared
4. The user looks at the ingredients of the coffee they chose

### Some design choices
CoffeeMachine with externally supplied in, out and err makes it possible to inject
dependencies and test. Flushing after every print removes differences between
streams that flush automatically and those that don't.
