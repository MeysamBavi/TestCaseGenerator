#!/usr/bin/env bash

set -o errexit
set -o nounset
set -o pipefail

TARGET="./target"
SOURCE="./src"

rm -rf "$TARGET" 2>/dev/null || true
mkdir "$TARGET"
javac -d "$TARGET" -cp "$SOURCE" "$SOURCE/Main.java"
java -cp "$TARGET" Main
