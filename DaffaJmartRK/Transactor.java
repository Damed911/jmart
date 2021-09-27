package DaffaJmartRK;

public abstract interface Transactor
{
    public boolean validate();
    public Invoice perform();
}
