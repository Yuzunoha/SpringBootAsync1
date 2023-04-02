release-up:
	docker-compose -f docker-compose-release.yml build --no-cache
	docker-compose -f docker-compose-release.yml

up:
	docker-compose up

down:
	docker-compose down

ps:
	docker-compose ps

bash:
	docker-compose exec demo bash

build:
	docker-compose build --no-cache