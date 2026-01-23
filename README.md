# Remote Probe Control

A Spring Boot application that controls a remote probe navigating a grid while avoiding obstacles.

This project is part of a problem set and focuses on clean design, correct navigation logic, and test-driven development.

---

## 🧠 Problem Overview

The remote probe:
- Starts at a given position on a grid
- Faces a direction (N, E, S, W)
- Executes a sequence of commands:
    - `F` → move forward
    - `B` → move backward
    - `L` → turn left
    - `R` → turn right
- Must avoid obstacles and stay within grid bounds

---

## Assumptions
- The probe cannot move outside the grid
- The probe stops before obstacles
- Only successful movements are recorded as visited positions
- Turning does not change position

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Maven
- JUnit

---

## Sample Request-Response
### Request -
    {
    "grid": {
        "width": 5,
        "height": 5,
        "obstacles": [
            { "x": 1, "y": 1 }
        ]
    },
    "start": {
        "x": 0,
        "y": 0,
        "direction": "NORTH"
    },
    "commands": "FFFRF"
    }
### Response -
    {
    "finalPosition": {
        "x": 1,
        "y": 3
    },
    "direction": "EAST",
    "visited": [
        {
            "x": 0,
            "y": 0
        },
        {
            "x": 0,
            "y": 1
        },
        {
            "x": 0,
            "y": 2
        },
        {
            "x": 0,
            "y": 3
        },
        {
            "x": 1,
            "y": 3
        }
    ]
    }

---

## ▶️ How to Run

```bash
mvn spring-boot:run
