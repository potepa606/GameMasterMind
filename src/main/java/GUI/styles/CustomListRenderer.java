package GUI.styles;

import GUI.levelModuleListeners.LevelGame;
import database.DataBaseAction;
import logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import static logic.LoadComponents.*;

public class CustomListRenderer extends DefaultListCellRenderer {
    private CustomLabel renderer;


    private static final ImageIcon crossIcon = new ImageIcon (LevelGame.resize(deleteIcon,10,10));


    public CustomListRenderer ( final JList list )
    {
        super ();
        renderer = new CustomLabel ();

        list.addMouseListener ( new MouseAdapter()
        {
            @Override
            public void mouseReleased ( MouseEvent e )
            {
                if ( SwingUtilities.isLeftMouseButton ( e ) )
                {
                    int index = list.locationToIndex ( e.getPoint () );
                    if ( index != -1 && list.isSelectedIndex ( index ) )
                    {
                        Rectangle rect = list.getCellBounds ( index, index );
                        Point pointWithinCell = new Point ( e.getX () - rect.x, e.getY () - rect.y );
                        Rectangle crossRect = new Rectangle ( rect.width - 9 - 5 - crossIcon.getIconWidth () / 2,
                                rect.height / 2 - crossIcon.getIconHeight () / 2, crossIcon.getIconWidth (), crossIcon.getIconHeight () );
                        if ( crossRect.contains ( pointWithinCell ) )
                        {
                            DefaultListModel model = ( DefaultListModel ) list.getModel ();

                            Player playerDousuniecia = (Player) model.get(index);
                            model.remove ( index );

                            Player.listOfPlayers.remove(playerDousuniecia);
                            DataBaseAction.removePlayers(playerDousuniecia.getIdPlayer());



                        }
                    }
                }
            }
        } );
    }

    /**
     * Returns custom renderer for each cell of the list.
     *
     * @param list         list to process
     * @param value        cell value (CustomData object in our case)
     * @param index        cell index
     * @param isSelected   whether cell is selected or not
     * @param cellHasFocus whether cell has focus or not
     * @return custom renderer for each cell of the list
     */
    @Override
    public Component getListCellRendererComponent ( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus )
    {
        renderer.setSelected ( isSelected );
        renderer.setData ( ( Player ) value );
        return renderer;
    }

    /**
     * Label that has some custom decorations.
     */
    private static class CustomLabel extends JLabel
    {
        private static final Color selectionColor = new Color ( 82, 158, 202 );

        private boolean selected;
        private Player player;

        public CustomLabel ()
        {
            super ();
            setOpaque ( false );
            setBorder ( BorderFactory.createEmptyBorder ( 0, 36 + 5, 0, 40 ) );
        }

        private void setSelected ( boolean selected )
        {
            this.selected = selected;
            setForeground ( selected ? Color.WHITE : Color.BLACK );
        }

        private void setData ( Player data )
        {
            this.player = data;
            setText ( "ID: " + data.getIdPlayer() + " \t\t " + data.getNamePlayer () );
        }

        @Override
        protected void paintComponent ( Graphics g )
        {
            Graphics2D g2d = ( Graphics2D ) g;
            g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );

            if ( selected )
            {
                Area area = new Area ( new Ellipse2D.Double ( 0, 0, 36, 36 ) );
                area.add ( new Area ( new RoundRectangle2D.Double ( 18, 3, getWidth () - 18, 29, 6, 6 ) ) );
                g2d.setPaint ( selectionColor );
                g2d.fill ( area );

                g2d.setPaint ( Color.red );
                g2d.fill ( new Ellipse2D.Double ( 2, 2, 32, 32 ) );
            }
            final Font oldFont = g2d.getFont ();
            final FontMetrics fm = g2d.getFontMetrics ();


            g2d.setPaint ( selectionColor );
            g2d.fill ( new Ellipse2D.Double ( 5, 5, 26, 26 ) );
            //g2d.drawImage ( tipIcon.getImage (), 5 + 13 - tipIcon.getIconWidth () / 2, 5 + 13 - tipIcon.getIconHeight () / 2, null );

            g2d.setPaint ( Color.BLACK );
            g2d.drawString ( "Wynik: "+player.getWynik(), 459, getHeight () / 2 + ( fm.getAscent () - fm.getLeading () - fm.getDescent () ) / 2 );
            g2d.setFont ( oldFont );


            if ( selected )
            {
                g2d.drawImage ( crossIcon.getImage (), getWidth () - 9 - 5 - crossIcon.getIconWidth () / 2,
                        getHeight () / 2 - crossIcon.getIconHeight () / 2, null );


                final String iloscPorb = "Ilosc prób: " + player.getCountSamples();
                final String poziom = "       " + player.getLevelGame().toUpperCase();

                g2d.setFont ( oldFont.deriveFont ( oldFont.getSize () - 1f ) );
                g2d.setPaint ( Color.BLACK );

                g2d.drawString ( iloscPorb+poziom, 230, getHeight () / 2 + ( fm.getAscent () - fm.getLeading () - fm.getDescent () ) / 2 );
                g2d.setFont ( oldFont );
            }

            super.paintComponent ( g );
        }

        @Override
        public Dimension getPreferredSize ()
        {
            final Dimension ps = super.getPreferredSize ();
            ps.height = 36;
            return ps;
        }
    }

}
