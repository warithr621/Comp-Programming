import os

# Directory to search (current directory by default)
start_dir = "."

empty_dirs = []

# Traverse from the bottom up so we can detect nested empty dirs
for root, dirs, files in os.walk(start_dir, topdown=False):
    # A directory is empty if it contains no files and all subdirs are empty
    if not files and all(os.path.join(root, d) in empty_dirs for d in dirs):
        if not os.listdir(root):  # Double check — completely empty
            empty_dirs.append(root)

# Output the results
print(f"Found {len(empty_dirs)} empty directories:\n")
for d in empty_dirs:
    print(d)