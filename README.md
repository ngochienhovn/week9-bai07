# Bài 7 — Review tự động trên Pull Request

## Workflow

- Trigger: **`pull_request`** vào nhánh **`main`** (xem `.github/workflows/pull-request.yml`).
- Job **`build`**: `mvn clean verify` (test + checkstyle plugin trong `pom.xml`).
- Job **`checkstyle-inline`**: **`dbelyaev/action-checkstyle@v3`** với `reporter: github-pr-review` để bình luận vi phạm trên diff (cùng `google_checks.xml` như Maven).

## Branch protection (thao tác trên GitHub)

1. **Settings → Branches → Add rule** cho `main`.
2. Bật **Require a pull request before merging** (tuỳ chọn thêm require review).
3. Bật **Require status checks to pass** và chọn các check từ workflow (`build`, có thể thêm `checkstyle-inline` tùy repo).

## Kiểm chứng đề bài

1. Tạo nhánh, cố tình vi phạm Checkstyle (ví dụ xóa Javadoc trên class `public`, hoặc dòng quá dài).
2. Mở PR vào `main` → bot/action ghi chú trên dòng code → PR không merge được cho đến khi sửa và push lại.

## Chạy local

```bash
chmod +x run.sh
./run.sh
```
