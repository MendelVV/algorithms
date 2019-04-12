# algorithms
Algorithms on Kotlin

Include on Gradle:

repositories {
    maven { url "https://raw.github.com/mendelvv/algorithms/mvn-repo/" }
}

dependencies {
    compile group: 'ru.mendel.apps', name: 'algorithms', version:'1.0'
}

Include on Maven:

<repositories>
    <repository>
        <id>lib-mvn-repo</id>
        <url>https://raw.github.com/mendelvv/algorithms/mvn-repo/</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>ru.mendel.apps</groupId>
        <artifactId>algorithms</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
