# Enhanced Mason Trades for Fabric

## Update Process

- Update whatever you are trying to update
- Update any version numbers that need to be updated
  - in `src/fabric.mod.json`
    - `version`
    - `depends\fabricloader`
    - `depends\minecraft`
    - `depends\java`
  - in `gradle.properties`
    - `minecraft_version`
    - `yarn_mappings`
    - `loader_version`
    - `mod_version`
    - `fabric_version`
  - in `.github/workflows/gradle.yml`
    - `MINECRAFT_VERSION`
    - `JAVA_VERSION`
    - `VERSION`
    - `RELEASE_NAME`
- Update the release type if needed
  - in `.github/workflows/gradle.yml`
    - `VERSION_TYPE`
