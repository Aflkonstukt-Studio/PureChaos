# Pure Chaos

A multi-project Minecraft mod with completely random and chaotic features.

## Project Structure

This repository contains two main components:

- **pure-chaos**: The MCreator-based component of the mod. Contains elements created using the MCreator GUI tool.
- **pure-spice**: The custom code component with manually written Java/Kotlin code.

## Development Guidelines

- **For MCreator Development**: Only modify the `pure-chaos` directory and use MCreator to edit the mod elements.
- **For Manual Coding**: Work in the `pure-spice` directory for custom implementation features.

## Building and Running

The project should be built and run through the `pure-spice` subproject, which will incorporate the features from both components.

Running `pure-chaos` standalone or through MCreator will result in a partial implementation with missing features.

## Installation

1. Clone the repository
2. Build using Gradle from the `pure-spice` directory
3. Install the resulting mod JAR file into your Minecraft mods folder

## Requirements

- Minecraft Forge/NeoForge
- Java 21+
- Gradle 8.x 