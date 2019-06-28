ci: build check
	@echo "TODO: CI is on its way."

build:
	@echo "TODO: add build steps"

check:
	@echo "TODO: add more check steps"

package:
	git archive --format=tar.gz -o "./tenon-ide-`git describe`.tar.gz" --prefix=tenon-ide/ HEAD

.PHONY: package build check ci
