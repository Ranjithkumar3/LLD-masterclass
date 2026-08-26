# Docker

## Why Docker?

Docker lets a project define the software it needs to run in a repeatable way.

Without Docker, a PulseBoard developer would manually install and configure JDK 21, PostgreSQL, MongoDB, Elasticsearch, Prometheus, and Grafana. Repeating that setup on another laptop is slow and can produce different versions or settings.

With Docker, the project declares the required runtime environment. On another machine:

```text
Install Docker Desktop → clone the repository → run docker compose up
```

Docker downloads the required images and starts the configured services. It does not remove the need to download software; it standardises and automates that setup.

## Core concepts

| Term | Meaning | PulseBoard example |
|---|---|---|
| Image | Immutable packaged blueprint for software | `postgres:17` |
| Container | A running instance of an image | `pulseboard-postgres` |
| Volume | Persistent Docker-managed storage | PostgreSQL database files |
| Port mapping | Makes a container port reachable from the host machine | `5432:5432` |
| Dockerfile | Instructions to build one custom image | Packages the PulseBoard Spring Boot app |
| Compose file | Declares and runs a set of related containers | Runs app, databases, and observability tools together |

```text
Image → run → Container

postgres:17 image → pulseboard-postgres container
```

You can run multiple containers from one image. Deleting a container does not delete the image. Data is retained only when it is stored in a volume or another persistent store.

## Dockerfile vs Compose

### Dockerfile

A `Dockerfile` builds a custom image for one application.

```text
PulseBoard source code + JDK 21 → PulseBoard application image
```

Use it when the project needs its own container image.

### compose.yaml

A `compose.yaml` file defines how multiple containers run together:

```text
PulseBoard app
PostgreSQL
MongoDB
Elasticsearch
Prometheus
Grafana
```

It configures images, ports, environment variables, persistent volumes, and service networking.

**Rule of thumb:** Dockerfile packages one application; Compose starts the local system around it.

### What does `docker compose up` start?

`docker compose up` starts **every service defined in the current `compose.yaml`**.

- If the file contains only `db`, it starts only PostgreSQL.
- If it contains `app` and `db`, it starts both the Spring Boot application and PostgreSQL.
- To start one named service only, use `docker compose up -d db`.

### Why have a Dockerfile at all?

PostgreSQL already has a published image, so Compose can run `postgres:17` directly. PulseBoard is *your* code, not a published image. A Dockerfile tells Docker how to package the built Spring Boot JAR with a JDK/JRE into a `pulseboard` image.

Later, Compose can build and run that image with:

```yaml
services:
  app:
    build: . # Uses the Dockerfile in the current folder
```

The same application image can then be run locally, built in CI, stored in a container registry, and deployed to Kubernetes.

## Local development approach for PulseBoard

Start small:

1. Run PostgreSQL in Docker.
2. Run Spring Boot from the IDE using a locally installed JDK 21.
3. Add MongoDB and Elasticsearch when their features are implemented.
4. Add Prometheus and Grafana after the application exposes metrics.
5. Containerise the Spring Boot app after the core application works locally.

Do not start every infrastructure dependency on day one.

## Essential commands

```bash
docker ps                    # List running containers
docker images                # List downloaded images
docker compose up -d         # Create/start services in the background
docker compose ps            # Show Compose service status
docker compose logs -f       # Follow logs
docker compose down          # Stop/remove containers; keep named volumes
docker compose down -v       # Stop/remove containers and delete named volumes/data
docker compose config        # Validate and show resolved Compose configuration
```

## Key Compose semantics

```yaml
services:
  db:
    image: postgres:17
    ports:
      - "5432:5432"
    environment:
      POSTGRES_DB: pulseboard
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
```

- `services`: containers to run.
- `image`: existing packaged software to run.
- `ports`: `host-port:container-port`.
- `environment`: configuration passed to the container.
- `volumes`: persistent or shared files.
- Containers in the same Compose project can communicate using service names, such as `db`.

## Common cautions

- Pin versions (`postgres:17`), not `latest`.
- Do not commit real passwords; put local secrets in `.env` and add it to `.gitignore`.
- `docker compose down` preserves named-volume data; `docker compose down -v` deletes it.
- Inside a container, `localhost` means that container itself. A PulseBoard app container should connect to PostgreSQL using the Compose service name `db`, not `localhost`.
