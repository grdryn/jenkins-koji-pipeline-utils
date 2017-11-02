# Jenkins-Koji pipeline utils

This is a simple pipeline library hosting various utility functions for interfacing
with koji build system directly from jenkins pipeline-scripts.

I.e. you should be able to do:

```
print getTaskState("$TASK_ID")

def bid = "${getTaskBuild('14377616')}"

print bid
print getBuildArchives(bid)
print getBuildInfo(bid)
```

No promises though ;)
