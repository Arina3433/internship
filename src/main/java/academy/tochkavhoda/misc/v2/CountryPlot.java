package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.iface.v2.HasArea;

import java.util.Objects;

public class CountryPlot implements HasArea {
    private int plotLength;
    private int plotWidth;
    private boolean hasVegetableGarden;

    public CountryPlot(int plotLength, int plotWidth, boolean hasVegetableGarden) {
        this.plotLength = plotLength;
        this.plotWidth = plotWidth;
        this.hasVegetableGarden = hasVegetableGarden;
    }

    public int getPlotLength() {
        return plotLength;
    }

    public void setPlotLength(int plotLength) {
        this.plotLength = plotLength;
    }

    public int getPlotWidth() {
        return plotWidth;
    }

    public void setPlotWidth(int plotWidth) {
        this.plotWidth = plotWidth;
    }

    public boolean isHasVegetableGarden() {
        return hasVegetableGarden;
    }

    public void setHasVegetableGarden(boolean hasVegetableGarden) {
        this.hasVegetableGarden = hasVegetableGarden;
    }

    @Override
    public double getArea() {
        return plotLength * plotWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryPlot that)) return false;
        return getPlotLength() == that.getPlotLength() && getPlotWidth() == that.getPlotWidth() && isHasVegetableGarden() == that.isHasVegetableGarden();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlotLength(), getPlotWidth(), isHasVegetableGarden());
    }
}
