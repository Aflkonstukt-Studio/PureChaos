# pure-spice

## About

pure-spice contains the manually coded features of the PureChaos mod and serves as the main build and run entry point for the project. It incorporates both the custom code in this directory and the MCreator-generated code from the `pure-chaos` component.

## Development

### Setup

1. Clone the entire PureChaos repository
2. Make sure you have JDK 17+ installed
3. Import the project into your IDE as a Gradle project

### Building

To build the complete mod:

```bash
cd pure-spice
./gradlew build
```

### Running

To run the mod in a development environment:

```bash
cd pure-spice
./gradlew runClient
```

## Contributing

When working on this component:

- Add custom code implementations in the appropriate src directories
- Use Kotlin for new procedures and special features
- Java can be used for mixins and compatibility code
- Ensure your changes work with the features defined in the `pure-chaos` component

## Structure

- `src/main/java` - Java source code (only use for mixins)
- `src/main/kotlin` - Kotlin source code
- `src/main/resources` - Resource files including assets and data

## Dependencies

This component manages the build dependencies for the entire mod. 