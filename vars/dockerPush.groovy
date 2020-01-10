def call(IMAGETAG)
{
    sh("docker push ${IMAGETAG}")
}
