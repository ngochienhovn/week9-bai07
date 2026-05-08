#!/usr/bin/env bash
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$ROOT_DIR"
mvn -B -q clean verify
echo "OK: Bai02 checkstyle + test thanh cong."
