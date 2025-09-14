# AutoSword Mod - Minecraft NeoForge 1.21.8

A Minecraft mod that automatically attacks with perfect sword timing, even when alt-tabbed or in menus.

## Features

- **Automatic Sword Attacks**: Automatically attacks with perfect timing based on sword cooldown
- **Works When Alt-Tabbed**: Continues attacking even when the game is not in focus or in menus
- **Smart Targeting**: Can target nearby entities or just swing the weapon
- **Toggle Keybind**: Press F6 to toggle auto-attack on/off
- **Configurable Settings**: Customize attack timing, target requirements, and more

## Download

### Latest Release
Download the latest JAR file from the [Releases](https://github.com/yourusername/mc-sword-spam/releases) page.

### Build from Source
1. Clone this repository
2. Install Java 21
3. Run `./gradlew build`
4. Find the JAR in `build/libs/`

## Installation

1. **Install NeoForge 1.21.8** for Minecraft
2. **Download the JAR** from releases or build it yourself
3. **Place the JAR** in your `.minecraft/mods/` folder
4. **Launch Minecraft** with NeoForge profile
5. **Press F6** to toggle auto-attack

## Configuration

The mod includes several configuration options:

- **Enabled**: Enable/disable auto sword attack
- **Attack Interval**: Attack interval in milliseconds (default: 600ms for sword)
- **Work in Menus**: Continue attacking when in menus or alt-tabbed
- **Only Swords**: Only auto-attack when holding a sword
- **Require Target**: Only attack when there's a valid target

## Controls

- **F6**: Toggle auto-attack on/off

## Building

This project uses GitHub Actions to automatically build the mod. Every push to main will:
1. Build the mod with Java 21
2. Create a release with the JAR file
3. Upload the JAR as a downloadable artifact

## License

This mod is licensed under the MIT License.

## Disclaimer

This mod is for educational purposes. Use responsibly and in accordance with server rules and terms of service.