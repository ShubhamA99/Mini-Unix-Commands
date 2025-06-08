
# Mini Unix Commands

A lightweight Java implementation of classic Unix commands, designed for modularity, readability, and ease of extension. Currently supports `cat` with line‑numbering options, pluggable input readers, and a pipeline-ready architecture.

## 🚀 Features

- `cat` command (NTU implementation) with support for:
  - `-n` — number **all** lines
  - `-b` — number **non-blank** lines
  - Default behavior when no flags provided
- Ready for future extensions like `grep`, `cut`, `head`, etc.



---

## 🎯 Roadmap

* 🌟 Add commands: `cut`, `grep`, `head`, `tail`, `wc`
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



