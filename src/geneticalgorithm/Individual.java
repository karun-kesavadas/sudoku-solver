package geneticalgorithm;

import config.Config;

import config.Constants;
import sudoku.SudokuGrid;
import sudoku.SudokuGridHelper;

import java.util.Arrays;

public final class Individual extends SudokuGrid implements Comparable<Individual>
{
    private SudokuGridHelper sudokuGridHelper;
    private int[] chromosome;

    public Individual()
    {
        super((SudokuGrid) Config.getInstance().getConfig(Constants.SUDOKU_GRID));
        this.sudokuGridHelper = (SudokuGridHelper) Config.getInstance().getConfig(Constants.SUDOKU_GRID_HELPER);
        this.chromosome = new int[this.sudokuGridHelper.getVariableFields().length];
        this.fillGridWithRandomNumbers();
    }

    public Individual(Individual other)
    {
        super(other);
        this.sudokuGridHelper = other.sudokuGridHelper;
        this.chromosome = Arrays.copyOf(other.getChromosome(), other.getChromosome().length);
    }

    private void fillGridWithRandomNumbers()
    {
        for (int i = 0; i < this.chromosome.length; i++)
        {
            this.insertRandomValue(i);
        }
    }

    public void insertRandomValue(int geneIndex)
    {
        int gridIndex = this.sudokuGridHelper.getVariableFields()[geneIndex];
        Integer[] validValues = this.sudokuGridHelper.getValidValuesForGridIndex(gridIndex);
        int randomValueIndex = (int) (Math.random() * validValues.length);
        this.setChromosome(geneIndex, validValues[randomValueIndex]);
    }

    public void setChromosome(int geneIndex, int value)
    {
        this.insert(this.sudokuGridHelper.getVariableFields()[geneIndex], value);
        this.chromosome[geneIndex] = value;
    }

    public int getChromosomeFromIndex(int index)
    {
        return this.getChromosome()[index];
    }


    public int[] getChromosome()
    {
        return this.chromosome;
    }

    /**
     * @return the fitness of the individual
     */
    public double getFitness()
    {
        return (81.0d-this.getConflictCount())/81.0d;
    }


    @Override
    public int compareTo(Individual o)
    {
        return Double.compare(o.getFitness(),this.getFitness());
    }
}
