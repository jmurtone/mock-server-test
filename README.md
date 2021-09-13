# mock-server-test

Running Spring Boot Test fails with mockserver for openjdk 1.8_302

```
mock-server-test % java -version
openjdk version "1.8.0_302"
OpenJDK Runtime Environment (build 1.8.0_302-bre_2021_08_14_21_34-b00)
OpenJDK 64-Bit Server VM (build 25.302-b00, mixed mode)
```
```
% gradlew check --rerun-tasks --info
...
Starting process 'Gradle Test Executor 42'. Working directory: /Users/janne.murtonen/Dev/Experimental/mock-server-test Command: /usr/local/Cellar/openjdk@8/1.8.0+302/libexec/openjdk.jdk/Contents/Home/bin/java -Djava.security.manager=worker.org.gradle.process.internal.worker.child.BootstrapSecurityManager -Dorg.gradle.internal.worker.tmpdir=/Users/janne.murtonen/Dev/Experimental/mock-server-test/build/tmp/test/work -Dorg.gradle.native=false -Xmx512m -Dfile.encoding=UTF-8 -Duser.country=FI -Duser.language=en -Duser.variant -ea -cp /Users/janne.murtonen/.gradle/caches/7.1.1/workerMain/gradle-worker.jar worker.org.gradle.process.internal.worker.GradleWorkerMain 'Gradle Test Executor 42'

MockServerTestApplicationTests > contextLoads() STANDARD_OUT
Spring application loaded.
#
# A fatal error has been detected by the Java Runtime Environment:
#
#  SIGSEGV (0xb) at pc=0x000000010b8a911a, pid=22783, tid=0x000000000000750b
#
# JRE version: OpenJDK Runtime Environment (8.0_302) (build 1.8.0_302-bre_2021_08_14_21_34-b00)
# Java VM: OpenJDK 64-Bit Server VM (25.302-b00 mixed mode bsd-amd64 compressed oops)
# Problematic frame:
# V  [libjvm.dylib+0x54611a]  Unsafe_SetByte+0x61
#
# Failed to write core dump. Core dumps have been disabled. To enable core dumping, try "ulimit -c unlimited" before starting Java again
#
# An error report file with more information is saved as:
# /Users/janne.murtonen/Dev/Experimental/mock-server-test/hs_err_pid22783.log
#
# If you would like to submit a bug report, please visit:
#   https://github.com/Homebrew/homebrew-core/issues
#
...
BUILD FAILED in 3s
```

Test method ```contextLoads``` runs succesfully (just remove ```@Test``` annotation from ```testMock()``` method).   