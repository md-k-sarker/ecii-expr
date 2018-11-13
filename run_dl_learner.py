# run dl-learner over a directory to execute the operations on all .conf files.
# it assumes that dl-learner command line interface is in system path
import subprocess
import os

# directory conatining the .conf files
directory='experimental_data'
# alias to call dl-learner command line interface
dl_learner_alias='dl_cli'

def run_dl_learner(filepath):
    t = subprocess.run([dl_learner_alias,filepath],stdout=subprocess.PIPE,universal_newlines=True)
    outputFilePath=filepath.replace('.conf','_expl_by_dl_learner_celoe.txt')
    print('writing output to ', outputFilePath)
    config_contents = ''
    with open(filepath, 'r') as config_file:
        config_contents = config_file.read()
    with open(outputFilePath, 'a') as the_file:
        the_file.write(config_contents)
        the_file.write('\n')
        the_file.write(t.stdout)

for subdir, dirs, files in os.walk(directory):
    for file in files:
        #print os.path.join(subdir, file)
        filepath = subdir + os.sep + file

        if filepath.endswith(".conf"):
            print('running dl-learner with ',filepath)
            run_dl_learner(filepath)

