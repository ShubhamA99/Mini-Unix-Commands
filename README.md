# Mini Unix Commands

A lightweight Java implementation of classic Unix commands, designed for modularity, readability, and ease of extension. Currently supports `cat` and `cut` commands with various options, pluggable input readers, and a pipeline-ready architecture.

## 🚀 Features

- `cat` command with support for:
  - `-n` — number **all** lines
  - `-b` — number **non-blank** lines
  - Default behavior when no flags provided
- `cut` command with support for:
  - Field-based cutting using `-f` option
  - Character-based cutting using `-c` option
  - Custom delimiter support
- Ready for future extensions like `grep`, `head`, etc.



---

## 🎯 Roadmap

* 🌟 Add commands:  `grep`, `head`, `tail`, `wc`
* 🌟 CLI parsing with pipes (`|`) and redirection (`>`, `<`)
* 🌟 Lazy stream handling via `Stream<String>`
* 🌟 `--help`, `--version`, rich CLI UX
* 🌟 JUnit test suite for commands and readers

---

## 🤝 Contributing

1. Fork & create a branch
2. Add tests/features
3. Submit a pull request with context

---

## 📄 License

MIT License — see [LICENSE](LICENSE)

---

## ☕ Thanks!

Inspired by Unix pipe-and-filter architecture. Feel free to open issues or submit PRs!



