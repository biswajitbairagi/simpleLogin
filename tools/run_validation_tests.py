#!/usr/bin/env python3
"""Compile and execute the real Java validator without an Android SDK."""

from pathlib import Path
import shutil
import subprocess
import sys
import tempfile


def main():
    root = Path(__file__).resolve().parents[1]
    java = shutil.which("java")
    javac = shutil.which("javac")
    if not java:
        print("Install a JDK and put java on PATH before running these tests.", file=sys.stderr)
        return 2
    compiler = [javac] if javac else [java, "com.sun.tools.javac.Main"]
    sources = [
        root / "app/src/main/java/com/example/artion/hyrnesistem/FormValidator.java",
        root / "validation-tests/FormValidatorTest.java",
    ]
    with tempfile.TemporaryDirectory(prefix="simplelogin-tests-") as output:
        subprocess.run(compiler + ["-encoding", "UTF-8", "-d", output]
                       + [str(path) for path in sources], check=True)
        subprocess.run([java, "-cp", output,
                        "com.example.artion.hyrnesistem.FormValidatorTest"], check=True)
    return 0


if __name__ == "__main__":
    try:
        sys.exit(main())
    except subprocess.CalledProcessError as error:
        sys.exit(error.returncode)
