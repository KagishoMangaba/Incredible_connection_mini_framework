🛒 Incredible Connection E-Commerce Test Automation Framework
Overview

This framework is designed to support end-to-end automated testing of the Incredible Connection e-commerce platform.
It validates critical business flows such as browsing, product search, cart management, and checkout to ensure a stable and reliable shopping experience for users.

The framework is engineered with production level practices to handle real world UI challenges such as dynamic content, synchronization issues, flaky elements, and cross-browser behavior.


Key Objectives

- Automate core user journeys on Incredible Connection
- Detect regressions early in the release cycle
- Minimize manual testing effort
- Enable parallel test execution
- Generate clear and actionable execution reports
- Provide a scalable structure for future expansion

 🚀 Features


- Integrated Chrome DevTools Protocol (CDP) with Selenium
- Valid and invalid test coverage
- Page Object Model (POM) architecture
- Reusable base class for setup and teardown
- Automatic screenshots captured on test failure
- Retry logic for unstable tests
- Parallel test execution enabled
- Data-driven testing using JSON
- Extent Reports for detailed execution reports
- CI/CD ready (Runs remotely with Jenkins)
- Runs on command terminal
- Docker Integration with SeleniumGrid

Technology Stack

- Java
- Selenium WebDriver
- TestNG
- Cucumber (BDD)
- Maven
- Docker + Selenium Grid
- Log4j for logging
- Extent Reports for reporting
- Git / GitHub

 🚫 Out of Scope

For now, this framework intentionally excludes full login and purchase flows.

This is mainly due to security and data protection concerns when working against a live production environment.
Automating real user authentication and payment transactions introduces risks that are simply not worth taking in a demo or learning framework.
That said, the framework is not limited by design.

The architecture, page structure, and test flow have all been built in a way that makes adding login and checkout scenarios straightforward and safe once a suitable test environment (with mock users and test payment data) is available.


## QA & Automation Highlights

This framework includes real-world QA improvements, such as:
- Resolving subtle login input issues through isolated responsibility methods
- Handling page overlays (like cookie banners) to stabilize automated interactions

Detailed documentation of defect discovery, analysis, and solutions is available in the docs folder.

